package com.milan.vum.activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Base64;

import com.milan.vum.R;
import com.milan.vum.fragment.BioDialogFragment;
import com.milan.vum.fragment.PeopleFragment;
import com.milan.vum.fragment.ShareLogFragment;
import com.milan.vum.fragment.WelcomeFragOne;
import com.milan.vum.utilities.ProjectConstants;

public class HomeActivity extends FragmentActivity {

   private ViewPager mPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.pager);
        ScreenSlidePagerAdapter screenSlidePagerAdapter=new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(screenSlidePagerAdapter);
        mPager.setCurrentItem(1);
    }

    public void callDialogFragment(String fragmentstring, Bundle bundle,Context context){
        switch(fragmentstring){

            case ProjectConstants.DialogFragment_Bio:
                BioDialogFragment bioDialogFragment=new BioDialogFragment();
                bioDialogFragment.show(getSupportFragmentManager(),ProjectConstants.DialogFragment_Bio);
                break;
        }
    }

    // method for base64 to bitmap
    public static Bitmap decodeBase64(String input) {
        if(input!=null){
            byte[] decodedByte = Base64.decode(input, 0);
            return BitmapFactory
                    .decodeByteArray(decodedByte, 0, decodedByte.length);
        }
        return null;
    }


    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }

    }

    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new ShareLogFragment();

                case 1:
                    return new WelcomeFragOne();

                case 2:
                    return new PeopleFragment();

                default:
                    return new WelcomeFragOne();
            }
        }



        @Override
        public int getCount() {
            return 3;
        }
    }


}
