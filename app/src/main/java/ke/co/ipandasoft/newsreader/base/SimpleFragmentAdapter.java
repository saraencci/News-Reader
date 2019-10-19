package ke.co.ipandasoft.newsreader.base;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

import ke.co.ipandasoft.newsreader.base.fragmentbase.BaseFragment;


public class SimpleFragmentAdapter<T extends BaseFragment> extends FragmentPagerAdapter {
    private List<T> fragments;

    public SimpleFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setFragments(List<T> fragments) {
        this.fragments = fragments;
    }

    public Fragment getItem(int position) {
        return this.fragments.get(position);
    }

    public int getCount() {
        return fragments.size();
    }

    public CharSequence getPageTitle(int position) {
        return this.fragments.get(position).getFragmentTitle();
    }
}
