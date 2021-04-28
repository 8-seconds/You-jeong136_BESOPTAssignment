package org.sopt.androidseminar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.sopt.androidseminar.databinding.FragmentFollowingBinding

class FollowingFragment : Fragment() {

    lateinit var followingListAdapter: FollowingListAdapter
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
        binding.userList.adapter = followingListAdapter

        followingListAdapter.userList.addAll(
            listOf<FollowingUserInfo>(
                FollowingUserInfo(
                    userImage = "지금은 빈킨",
                    userName = "jinsu1"
                ),
                FollowingUserInfo(
                    userImage = "지금은 빈킨",
                    userName = "jinsu2"
                ),
                FollowingUserInfo(
                    userImage = "지금은 빈킨",
                    userName = "jinsu3"
                ),FollowingUserInfo(
                    userImage = "지금은 빈킨",
                    userName = "jinsu4"
                )

            )
        )
        followingListAdapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}