package org.sopt.androidseminar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.sopt.androidseminar.databinding.FragmentFollowingBinding

class FollowingFragment : Fragment() {

    lateinit var followingListAdapter: FollowingListAdapter
    lateinit var binding: FragmentFollowingBinding
    //여기서 바로 = fragment~.inflate 하지 말아라 _ get()으로 받아와야  null safty 하다 _ 코드 참고.
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFollowingBinding.inflate(inflater, container, false)
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

}