package br.com.cmb.exfragmentsviewpaperswipe;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;


public class MyTabListener implements ActionBar.TabListener {
    private ViewPager viewPager;
    private int idx;

    // Construtor
    public MyTabListener(ViewPager viewPager, int idx) {
        this.viewPager = viewPager;
        this.idx = idx;
    }

    // Navega para a página desejada do ViewPager
    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {

        viewPager.setCurrentItem(idx);
    }

    // Chamado quando a tab perde o foco (se outra tab é selecionada)
    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    // Chamado quando uma tab é selecionada novamente.
    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}

