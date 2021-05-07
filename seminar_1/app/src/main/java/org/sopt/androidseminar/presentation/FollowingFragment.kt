package org.sopt.androidseminar.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.sopt.androidseminar.data.FollowingDataSource
import org.sopt.androidseminar.data.LocalFollowingDataSource
import org.sopt.androidseminar.databinding.FragmentFollowingBinding


class FollowingFragment : Fragment() {

    private lateinit var followingListAdapter: FollowingListAdapter
    private lateinit var followDataSource: FollowingDataSource

    private var _binding: FragmentFollowingBinding? = null
    private val binding get() = _binding?:error("View를 참조하기 위해 binding이 초기화 되지 않았습니다.")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFollowingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        followingListAdapter = FollowingListAdapter()
        followDataSource = LocalFollowingDataSource()
        val followList = followDataSource.fetchFollowingData()

        binding.userList.adapter = followingListAdapter

        followingListAdapter.replaceList(followList)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}