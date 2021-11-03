package com.latifah.dogs.ui.fragments.likes

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.latifah.dogs.data.models.Likes
import com.latifah.dogs.databinding.FragmentLikesBinding
import com.latifah.dogs.logic.LikesApplication
import com.latifah.dogs.ui.fragments.likes.adapters.LikesImageGridAdapter
import com.latifah.dogs.ui.viewmodel.LikesViewModel
import com.latifah.dogs.ui.viewmodel.LikesViewModelFactory

class LikesFragment : Fragment() {
    private var _binding: FragmentLikesBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView

    private lateinit var likesList : List<Likes>
    private val likesViewModel : LikesViewModel by activityViewModels {
        LikesViewModelFactory(
            (activity?.application as LikesApplication).repository
        )
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)

        _binding = FragmentLikesBinding.inflate(inflater)


        binding.lifecycleOwner = this

        // Giving the binding access to the likeViewModel

        binding.likesViewModel = likesViewModel
        binding.likesGrid.adapter = LikesImageGridAdapter()

        return binding.root
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
////        viewModel.message.observe(viewLifecycleOwner, {
////            binding.textView2.text = it
////            likeImg = it
////            Log.d("inside observer", "observe: ${it}")
////        })
//
////        binding.likesGrid.adapter= LikesImageGridAdapter()
//
//        recyclerView = binding.likesGrid
//        recyclerView.layoutManager = LinearLayoutManager(requireContext())
//
//        likesViewModel.allLikes.observe(viewLifecycleOwner, {
//            it?.let {
//                likesList = it
//            }
//            Log.d("inside observer", "observe: ${it}")
//        })
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}