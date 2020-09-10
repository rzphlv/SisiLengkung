package rzphlv.nmf.sisilengkung.Bola;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

/**
 * Fragment to return the clicked tab.
 */
public class PagerAdapterBola extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapterBola(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    /**
     * Return the Fragment associated with a specified position.
     *
     * @param position
     */
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: return new TabMateriBola();
            case 1: return new TabContohSoalBola();
            case 2: return new TabLatihanBola();
            default: return null;
        }
    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
