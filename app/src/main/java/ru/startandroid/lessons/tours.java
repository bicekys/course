package ru.startandroid.lessons;
import android.os.Bundle;
        import android.support.v4.app.Fragment;
        import android.support.v4.app.FragmentActivity;
        import android.support.v4.app.FragmentManager;
        import android.support.v4.app.FragmentTransaction;
        import android.view.Menu;
        import android.view.MenuItem;

public class tours extends FragmentActivity {
    private Fragment contentFragment;
  tourListFra pdtListFragment;
    save favListFragment;
    @Override
   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tours);
        FragmentManager fragmentManager = getSupportFragmentManager();
/*
* This is called when orientation is changed.
*/
        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("content")) {
                String content = savedInstanceState.getString("content");
                if (content.equals(save.ARG_ITEM_ID)) {
                    if (fragmentManager.findFragmentByTag(save.ARG_ITEM_ID) != null) {
                      //  setFragmentTitle(R.string.favorites);
                        contentFragment = fragmentManager
                                .findFragmentByTag(save.ARG_ITEM_ID);
                    }
                }
            }
            if (fragmentManager.findFragmentByTag(tourListFra.ARG_ITEM_ID) != null) {
                pdtListFragment = (tourListFra) fragmentManager
                        .findFragmentByTag(tourListFra.ARG_ITEM_ID);
                contentFragment = pdtListFragment;
            }
        } else {
            pdtListFragment = new tourListFra();
          //  setFragmentTitle(R.string.app_name);
            switchContent(pdtListFragment,tourListFra.ARG_ITEM_ID);
       }
    }
    @Override
   protected void onSaveInstanceState(Bundle outState) {
        if (contentFragment instanceof save) {
            outState.putString("content", save.ARG_ITEM_ID);
        } else {
            outState.putString("content", tourListFra.ARG_ITEM_ID);
        }
        super.onSaveInstanceState(outState);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_favorites:
               // setFragmentTitle(R.string.favorites);
                favListFragment = new save();
                switchContent(favListFragment, save.ARG_ITEM_ID);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void switchContent(Fragment fragment, String tag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        while (fragmentManager.popBackStackImmediate());
        if (fragment != null) {
            FragmentTransaction transaction = fragmentManager
                    .beginTransaction();
           transaction.replace(R.id.content_frame, fragment, tag);
//Only FavoriteListFragment is added to the back stack.
            if (!(fragment instanceof tourListFra)) {
                transaction.addToBackStack(tag);
            }
            transaction.commit();
            contentFragment = fragment;
        }
    }
    /*protected void setFragmentTitle(int resourseId) {
        setTitle(resourseId);
        getActionBar().setTitle(resourseId);
   }*/
/*

* We call super.onBackPressed(); when the stack entry count is > 0. if it

* is instanceof ProductListFragment or if the stack entry count is == 0, then

* we finish the activity.

* In other words, from ProductListFragment on back press it quits the app.

*/
    @Override
    public void onBackPressed() {
        FragmentManager fm = getSupportFragmentManager();
        if (fm.getBackStackEntryCount() > 0) {
            super.onBackPressed();
        } else if (contentFragment instanceof tourListFra
                || fm.getBackStackEntryCount() == 0) {
            finish();
        }
    }
}