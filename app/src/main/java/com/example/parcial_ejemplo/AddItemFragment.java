package com.example.parcial_ejemplo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.gson.Gson;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddItemFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddItemFragment extends Fragment {
    private Button button;
    private EditText codigo, nombre, cantidad, precio, descripcion;
    private Spinner talla;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AddItemFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddItemFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddItemFragment newInstance(String param1, String param2) {
        AddItemFragment fragment = new AddItemFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_item, container, false);


        button = view.findViewById(R.id.button);
        codigo = view.findViewById(R.id.code);
        nombre = view.findViewById(R.id.name);
        cantidad = view.findViewById(R.id.stock);
        precio = view.findViewById(R.id.sale);
        talla = view.findViewById(R.id.sizeSpinner);
        descripcion = view.findViewById(R.id.description);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Gson gson = new Gson();

                String code = codigo.getText().toString();
                String name = nombre.getText().toString();
                int stock = Integer.parseInt(cantidad.getText().toString());
                double sale = Double.parseDouble(precio.getText().toString()) ;
                String size = talla.getSelectedItem().toString();
                String description = descripcion.getText().toString();

                Item item = new Item(code,name,stock,sale,size,description);
                String data = gson.toJson(item);

                ViewItemFragment fragmentB = new ViewItemFragment();
                Bundle bundle = new Bundle();
                bundle.putString("data", data);
                fragmentB.setArguments(bundle);

                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame_layout, fragmentB)
                        .addToBackStack(null)
                        .commit();
            }
        });

        return view;
    }


}