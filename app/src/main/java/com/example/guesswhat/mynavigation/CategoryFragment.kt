package com.example.guesswhat.mynavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.guesswhat.mynavigation.databinding.FragmentCategoryBinding

/**
 * A simple [Fragment] subclass.
 */
class CategoryFragment : Fragment() {

    private var _binding: FragmentCategoryBinding? = null
    private val binding get() = _binding!!

    companion object {
        val EXTRA_NAME = "extra_name"
        val EXTRA_STOCK = "extra_stock"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        _binding = FragmentCategoryBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//       binding.btnCategoryLifestyle.setOnClickListener { view ->
//            val mBundle = Bundle()
//            mBundle.putString(EXTRA_NAME, "Lifestyle")
//            mBundle.putLong(EXTRA_STOCK, 7)
//            view.findNavController().navigate(R.id.action_categoryFragment_to_detailCategoryFragment, mBundle)
//        }

        binding.btnCategoryLifestyle.setOnClickListener { view ->
            val toDetailCategoryFragment = CategoryFragmentDirections.actionCategoryFragmentToDetailCategoryFragment()
            toDetailCategoryFragment.name = "Lifestyle"
            toDetailCategoryFragment.stock = 7
            view.findNavController().navigate(toDetailCategoryFragment)
        }
        binding.btnHome.setOnClickListener{ view ->
            //Navigation.createNavigateOnClickListener(R.id.action_detailCategoryFragment_to_homeFragment)
        val toHomeFragment = CategoryFragmentDirections.actionCategoryFragmentToHomeFragment()
        view.findNavController().navigate(toHomeFragment)

    }
        binding.btnDataset.setOnClickListener{ view ->
            //Navigation.createNavigateOnClickListener(R.id.action_detailCategoryFragment_to_homeFragment)
            val toDatasetFragment = CategoryFragmentDirections.actionCategoryFragmentToDatasetFragment()
            view.findNavController().navigate(toDatasetFragment)

        }
        binding.btnFitur.setOnClickListener{ view ->
            //Navigation.createNavigateOnClickListener(R.id.action_detailCategoryFragment_to_homeFragment)
            val toFiturFragment = CategoryFragmentDirections.actionCategoryFragmentToFitur()
            view.findNavController().navigate(toFiturFragment)

        }
        binding.btnModel.setOnClickListener{ view ->
            //Navigation.createNavigateOnClickListener(R.id.action_detailCategoryFragment_to_homeFragment)
            val toModelFragment = CategoryFragmentDirections.actionCategoryFragmentToModel()
            view.findNavController().navigate(toModelFragment)

        }
        binding.btnSimulasimodel.setOnClickListener{ view ->
            //Navigation.createNavigateOnClickListener(R.id.action_detailCategoryFragment_to_homeFragment)
            val tosimulasimodel = CategoryFragmentDirections.actionCategoryFragmentToSimulasimodel()
            view.findNavController().navigate(tosimulasimodel)

        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
