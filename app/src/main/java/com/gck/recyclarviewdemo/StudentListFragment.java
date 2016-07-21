package com.gck.recyclarviewdemo;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.gck.student.Student;
import com.gck.student.StudentManager;

import java.util.ArrayList;
import java.util.List;


public class StudentListFragment extends Fragment {

    private RecyclerView recyclerView;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;
    private ListAdapter listAdapter;
    private EditText editText;
    private List<Student> studentData;

    public StudentListFragment() {
    }


    public static StudentListFragment newInstance() {
        StudentListFragment fragment = new StudentListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_student_list, container, false);
        editText = (EditText) view.findViewById(R.id.search_edit);
        editText.addTextChangedListener(textWatcher);
        recyclerView = (RecyclerView) view.findViewById(R.id.list);
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        studentData=new ArrayList<>();
        studentData.addAll(StudentManager.getInstance().getData());
        listAdapter = new ListAdapter(getContext(), studentData);

        recyclerView.setAdapter(listAdapter);


        return view;
    }

    private TextWatcher textWatcher=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            List<Student> data = StudentManager.getInstance().getData(s.toString());
            studentData.clear();
            studentData.addAll(data);

            listAdapter.notifyDataSetChanged();
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };



    public void showEditText(boolean show) {
        editText.setVisibility(show ? View.VISIBLE : View.GONE);
        if(!show){
            editText.setText("");
        }
    }

    private static class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

        private Context context;
        private List<Student> studentList;

        public ListAdapter(Context context, List<Student> studentList) {
            this.context = context;
            this.studentList = studentList;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);

            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            Student student = studentList.get(position);
            holder.idTv.setText(student.getId() + "");
            holder.nameTv.setText(student.getName());
        }

        @Override
        public int getItemCount() {
            return studentList.size();
        }

        static class ViewHolder extends RecyclerView.ViewHolder {
            private TextView nameTv,idTv;
            private ImageView imageView;

            public ViewHolder(View itemView) {
                super(itemView);
                nameTv = (TextView) itemView.findViewById(R.id.name);
                idTv= (TextView) itemView.findViewById(R.id.num);
            }
        }


    }

}
