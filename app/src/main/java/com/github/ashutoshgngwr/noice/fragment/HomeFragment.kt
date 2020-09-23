package com.github.ashutoshgngwr.noice.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.github.ashutoshgngwr.noice.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(R.layout.fragment_home) {

  private val titles = arrayOf(
    R.string.library,
    R.string.transition_groups
  )

  private val fragments = arrayOf(
    SoundLibraryFragment::class.java,
    TransitionGroupListFragment::class.java
  )

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    view_pager.adapter = object : FragmentStateAdapter(this) {
      override fun getItemCount() = fragments.size
      override fun createFragment(position: Int) = fragments[position].newInstance()
    }

    TabLayoutMediator(tab_layout, view_pager) { tab: TabLayout.Tab, position: Int ->
      tab.setText(titles[position])
    }.attach()
  }
}
