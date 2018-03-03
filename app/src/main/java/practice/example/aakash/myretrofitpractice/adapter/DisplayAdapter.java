package practice.example.aakash.myretrofitpractice.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import practice.example.aakash.myretrofitpractice.R;
import practice.example.aakash.myretrofitpractice.databinding.DisplayBinding;
import practice.example.aakash.myretrofitpractice.model.Employee;

/**
 * Created by aakash on 3/3/18.
 */

public class DisplayAdapter extends RecyclerView.Adapter<DisplayAdapter.DisplayViewHolder> {
    private List<Employee>employeeList;

    class DisplayViewHolder extends RecyclerView.ViewHolder{
         DisplayBinding displayBinding;
        public DisplayViewHolder(View v) {
            super(v);
            displayBinding=DisplayBinding.bind(v);
        }
    }

    @Override
    public DisplayViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.display,parent,false);
        return new DisplayViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DisplayViewHolder holder, int position) {
        holder.displayBinding.userName.setText(employeeList.get(position).getName());
        holder.displayBinding.userEmail.setText(employeeList.get(position).getEmail());
        holder.displayBinding.userPhone.setText(employeeList.get(position).getPhone());
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    public DisplayAdapter(List<Employee> employeeList) {
        this.employeeList=employeeList;
    }
}
