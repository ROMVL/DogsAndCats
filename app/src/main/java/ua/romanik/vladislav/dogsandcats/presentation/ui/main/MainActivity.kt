package ua.romanik.vladislav.dogsandcats.presentation.ui.main

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import ua.romanik.vladislav.dogsandcats.R
import ua.romanik.vladislav.dogsandcats.databinding.ActivityMainBinding
import ua.romanik.vladislav.dogsandcats.presentation.ui.cats_list.CatsFragment
import ua.romanik.vladislav.dogsandcats.presentation.ui.dogs_list.DogsFragment


class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.java.name

    companion object {
        private const val SELECTED_TAB = "selected_tab"
    }

    private var catsFragment: CatsFragment = CatsFragment.newInstance()
    private var dogsFragment: DogsFragment = DogsFragment.newInstance()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.BaseOnTabSelectedListener<TabLayout.Tab> {
            override fun onTabReselected(tab: TabLayout.Tab?) {}

            override fun onTabUnselected(p0: TabLayout.Tab?) {}

            override fun onTabSelected(tab: TabLayout.Tab?) {
                Log.d(TAG, "onTabSelected position tab ${tab?.position}")
                if (tab?.position == 0) {
                    changeScreen(catsFragment)
                } else {
                    changeScreen(dogsFragment)
                }
            }
        })
        savedInstanceState?.let {
            binding.tabLayout.getTabAt(it.getInt(SELECTED_TAB))?.select()
        } ?: changeScreen(catsFragment)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(SELECTED_TAB, binding.tabLayout.selectedTabPosition)
        super.onSaveInstanceState(outState)
    }

    fun showTabs(isShow: Boolean = true) {
        binding.tabLayout.visibility = if (isShow) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }

    fun changeScreen(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.flContainer,
                fragment,
                fragment::class.java.name
            )
            .commit()
    }

    fun changeScreenToDetails(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.flContainer,
                fragment,
                fragment::class.java.name
            )
            .addToBackStack(fragment::javaClass.name)
            .commit()
    }
}
