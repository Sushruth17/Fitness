package com.seventeen.fitness.ui.home

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
import com.seventeen.fitness.adapter.PostsAdapter
import com.seventeen.fitness.adapter.StoriesAdapter
import com.seventeen.fitness.model.Post


class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel::class.java)

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

        val postList = ArrayList<Post>()

/*        for (i in 0 until status.size)
            statusList.add(InstaStatus(status[i].id, status[i].name, status[i].picture))*/

        for (j in post.indices)
            postList.add(Post(post[j].id, post[j].name, post[j].logo, post[j].photo, post[j].likes, post[j].description))


        val storyAdapter = StoriesAdapter()
        storyAdapter.setDataCustom(fitnessTypeList)
        rvStories?.layoutManager  = LinearLayoutManager(
            activity, LinearLayoutManager.HORIZONTAL, false)
        rvStories?.adapter = storyAdapter

        val postAdapter = PostsAdapter(requireActivity(), postList)
        rvPosts?.layoutManager  = LinearLayoutManager(
            activity, LinearLayoutManager.VERTICAL, false)
        rvPosts?.adapter = postAdapter

    }
}