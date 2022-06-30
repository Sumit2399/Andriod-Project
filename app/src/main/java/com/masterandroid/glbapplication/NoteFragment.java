package com.masterandroid.glbapplication;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NoteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NoteFragment extends Fragment {
    DownloadManager dm;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NoteFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NoteFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NoteFragment newInstance(String param1, String param2) {
        NoteFragment fragment = new NoteFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_note, container, false);
        Button button3=(Button)view.findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Download_Click1(v);
            }
        });
        Button button4=(Button)view.findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Download_Click2(v);
            }
        });
        Button button5=(Button)view.findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Download_Click3(v);
            }
        });
        Button button6=(Button)view.findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Download_Click4(v);
            }
        });
        Button button7=(Button)view.findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Download_Click5(v);
            }
        });
        return view;
    }
    public void Download_Click1(View v){
        dm=(DownloadManager)getActivity().getSystemService(Context.DOWNLOAD_SERVICE);
        //https://drive.google.com/file/d/1eWf8pFBqM_ZDTNmFNoCOiz9pQrowIZY-/view?usp=sharing
        Uri uri=Uri.parse("https://drive.google.com/uc?export=download&id=1BBDdm0TvkEO-osynACmjs7BiCECkNAjH");

        DownloadManager.Request request=new DownloadManager.Request(uri);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        Long reference=dm.enqueue(request);
    }
    public void Download_Click2(View v){
        dm=(DownloadManager)getActivity().getSystemService(Context.DOWNLOAD_SERVICE);
        //https://drive.google.com/file/d/1eWf8pFBqM_ZDTNmFNoCOiz9pQrowIZY-/view?usp=sharing
        Uri uri=Uri.parse("https://drive.google.com/uc?export=download&id=1jsIxWSAnAYRytZWgZNKQ76B_7l8FqEc2");

        DownloadManager.Request request=new DownloadManager.Request(uri);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        Long reference=dm.enqueue(request);
    }
    public void Download_Click3(View v){
        dm=(DownloadManager)getActivity().getSystemService(Context.DOWNLOAD_SERVICE);
        //https://drive.google.com/file/d/1eWf8pFBqM_ZDTNmFNoCOiz9pQrowIZY-/view?usp=sharing
        Uri uri=Uri.parse("https://drive.google.com/uc?export=download&id=1rF8k9WN4UTYXqJHNEhape74aF2jnM7gd");

        DownloadManager.Request request=new DownloadManager.Request(uri);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        Long reference=dm.enqueue(request);
    }
    public void Download_Click4(View v){
        dm=(DownloadManager)getActivity().getSystemService(Context.DOWNLOAD_SERVICE);
        //https://drive.google.com/file/d/1eWf8pFBqM_ZDTNmFNoCOiz9pQrowIZY-/view?usp=sharing
        //https://drive.google.com/file/d/1jBb4uriotJOswJn-OUyfrw7jLZ2LoZkR/view?usp=sharing
        Uri uri=Uri.parse("https://drive.google.com/uc?export=download&id=1jBb4uriotJOswJn-OUyfrw7jLZ2LoZkR");

        DownloadManager.Request request=new DownloadManager.Request(uri);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        Long reference=dm.enqueue(request);
    }
    public void Download_Click5(View v){
        dm=(DownloadManager)getActivity().getSystemService(Context.DOWNLOAD_SERVICE);
        //https://drive.google.com/file/d/1eWf8pFBqM_ZDTNmFNoCOiz9pQrowIZY-/view?usp=sharing
        //https://drive.google.com/file/d/1krGBlLmbFHr1zYxw7_zM9-r25a2tsyFl/view?usp=sharing
        Uri uri=Uri.parse("https://drive.google.com/uc?export=download&id=1krGBlLmbFHr1zYxw7_zM9-r25a2tsyFl");

        DownloadManager.Request request=new DownloadManager.Request(uri);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        Long reference=dm.enqueue(request);
    }
}