package ru.startandroid.lessons;
import android.os.Bundle;
        import android.support.v4.app.Fragment;
        import android.support.v4.app.FragmentActivity;
        import android.support.v4.app.FragmentManager;
        import android.support.v4.app.FragmentTransaction;
    public class tours extends FragmentActivity {
  private Fragment contentFragment;
  tourListFra pdtListFragment;
    save favListFragment;
    @Override
   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tours);
      FragmentManager fragmentManager = getSupportFragmentManager();
        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("content")) {
                String content = savedInstanceState.getString("content");
                if (content.equals(save.ARG_ITEM_ID)) {
                    if (fragmentManager.findFragmentByTag(save.ARG_ITEM_ID) != null) {
                     contentFragment = fragmentManager.findFragmentByTag(save.ARG_ITEM_ID);}}}
            if (fragmentManager.findFragmentByTag(tourListFra.ARG_ITEM_ID) != null) {
                pdtListFragment = (tourListFra) fragmentManager.findFragmentByTag(tourListFra.ARG_ITEM_ID);
                contentFragment = pdtListFragment;
            }
        } else {
            pdtListFragment = new tourListFra();
        switchContent(pdtListFragment,tourListFra.ARG_ITEM_ID);
    }
    }
       public void switchContent(Fragment fragment, String tag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        while (fragmentManager.popBackStackImmediate());
        if (fragment != null) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
           transaction.replace(R.id.content_frame, fragment, tag);
            if (!(fragment instanceof tourListFra)) {
                transaction.addToBackStack(tag); }
            transaction.commit();
            contentFragment = fragment;}}
    @Override
    public void onBackPressed() {
        FragmentManager fm = getSupportFragmentManager();
        if (fm.getBackStackEntryCount() > 0) {
            super.onBackPressed();
        }  {
            finish();}}}