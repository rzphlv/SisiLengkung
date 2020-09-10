package rzphlv.nmf.sisilengkung.Kerucut;

import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import rzphlv.nmf.sisilengkung.R;

public class TabLatihanKerucut extends Fragment {

    public TabLatihanKerucut(){

    }

    public View onCreate(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        return inflater.inflate(R.layout.tab_latihan_kerucut,container, false);
    }
}
