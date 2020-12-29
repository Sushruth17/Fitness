package com.seventeen.fitness.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.seventeen.fitness.R
import com.seventeen.fitness.adapter.PostAdapter
import com.seventeen.fitness.adapter.StoryAdapter2
import com.seventeen.fitness.model.Post
import com.seventeen.fitness.model.Story
import com.seventeen.fitness.ui.home.HomeViewModel


class HomeFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fitnessTypeList = listOf("1", "2", "3", "4", "5", "6")
        val listSamp = arrayListOf<Post>()

        val rvStories = getView()?.findViewById<RecyclerView>(R.id.rv_stories)
        val rvPosts = getView()?.findViewById<RecyclerView>(R.id.rv_posts)

        val postJSON: String? = activity?.assets?.open("post.json")?.bufferedReader().use { it?.readText() }
        val post = Gson().fromJson(postJSON, Array<Post>::class.java)

        val storyJSON: String? = activity?.assets?.open("story.json")?.bufferedReader().use { it?.readText() }
        val story = Gson().fromJson(storyJSON, Array<Story>::class.java)

        val postList = ArrayList<Post>()
        val storyList = ArrayList<Story>()

        for (i in story.indices)
            storyList.add(Story(story[i].id, story[i].name, story[i].picture))

        for (j in post.indices)
            postList.add(Post(post[j].id, post[j].name, post[j].logo, post[j].photo, post[j].likes, post[j].description))

        val storyAdapter = StoryAdapter2(requireActivity(), storyList)
//        storyAdapter.setDataCustom(fitnessTypeList)
        rvStories?.layoutManager  = LinearLayoutManager(
            activity, LinearLayoutManager.HORIZONTAL, false)
        rvStories?.adapter = storyAdapter

        val postAdapter = PostAdapter(requireActivity(), postList)
        rvPosts?.layoutManager  = LinearLayoutManager(
            activity, LinearLayoutManager.VERTICAL, false)
        rvPosts?.adapter = postAdapter

    }
}