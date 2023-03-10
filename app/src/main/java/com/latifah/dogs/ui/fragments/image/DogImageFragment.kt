package com.latifah.dogs.ui.fragments.image

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.latifah.dogs.R
import com.latifah.dogs.data.models.Likes
import com.latifah.dogs.databinding.FragmentDogImageBinding
import com.latifah.dogs.logic.LikesApplication
import com.latifah.dogs.ui.viewmodel.ImageViewModel
import com.latifah.dogs.ui.viewmodel.LikesViewModel
import com.latifah.dogs.ui.viewmodel.LikesViewModelFactory

class DogImageFragment : Fragment() {

    private var _binding: FragmentDogImageBinding? = null
    private val binding get() = _binding!!
    private val viewModel : ImageViewModel by viewModels()
    private val likesViewModel : LikesViewModel by activityViewModels {
        LikesViewModelFactory(
            (activity?.application as LikesApplication).repository
        )
    }
    private var likeImg = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDogImageBinding.inflate(inflater)

        binding.lifecycleOwner = this

        // Giving the binding access to the ImageViewModel

        binding.imageViewModel = viewModel

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.message.observe(viewLifecycleOwner) {
            likeImg = it
        }

        binding.btnGetDog.setOnClickListener {
            viewModel.getDogImage()

        }

        binding.floatingActionButton.setOnClickListener {
            addLike()
        }

        //click prev button
        //get history count
        // if it's 0 or null
        //disable button
        //else get last added image id
        //then getHistoryImageById(id - 1)
        //replace the dogImage with the history
    }

    private fun addLike() {
        if (likeImg.isNotEmpty()) {
            val like = Likes(0, likeImg)
            likesViewModel.addLike(like)
            Toast.makeText(context, "You liked a doggo", Toast.LENGTH_SHORT).show()

        } else {
            Toast.makeText(context, "There was an error ", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.item_menu, menu)
    }

    //TODO get menu to display
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_fav ->  findNavController().navigate(R.id.action_dogImageFragment_to_likesFragment)
        }
        return super.onOptionsItemSelected(item)
    }
}