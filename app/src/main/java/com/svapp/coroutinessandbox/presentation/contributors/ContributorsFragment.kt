package com.svapp.coroutinessandbox.presentation.contributors

import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import com.svapp.coroutinessandbox.R
import com.svapp.coroutinessandbox.data.model.Contributor
import com.svapp.coroutinessandbox.databinding.FragmentContributorsBinding
import com.svapp.coroutinessandbox.presentation.base.BaseFragment
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by Valentyn on 03.03.2019.
 */
class ContributorsFragment : BaseFragment<FragmentContributorsBinding>(), ContributorsAdapter.ContributorClickListener {

    private val mViewModel: ContributorsViewModel by viewModel()

    override fun getLayoutResId(): Int = R.layout.fragment_contributors

    override fun setupViews() {
        binding.contributorsRecyclerView.adapter = ContributorsAdapter(this)
        binding.viewModel = mViewModel
        binding.lifecycleOwner = this
    }

    override fun onContributorClick(contributor: Contributor) {
        val bundle = bundleOf("argLogin" to contributor.login)
        view?.findNavController()?.navigate(R.id.action_contributorsListFragment_to_contributorDetailsFragment, bundle)
    }

}