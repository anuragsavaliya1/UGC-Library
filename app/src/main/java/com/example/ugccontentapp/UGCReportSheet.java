package com.example.ugccontentapp;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.widget.Toast;

import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;



import com.example.ugccontentapp.databinding.BottomSheetUgcreportBinding;
import com.google.android.material.bottomsheet.BottomSheetDialog;



public class UGCReportSheet {

    private final BottomSheetDialog bottomSheetDialog;
    private boolean submitButtonEnable = false;

    public UGCReportSheet(Context context, String hostId, String userId, OnReportedListner onReportedListner) {
        bottomSheetDialog = new BottomSheetDialog(context, R.style.CustomBottomSheetDialogTheme);
        bottomSheetDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        BottomSheetUgcreportBinding sheetDilogBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.bottom_sheet_ugcreport, null, false);
        bottomSheetDialog.setContentView(sheetDilogBinding.getRoot());
        bottomSheetDialog.show();


        sheetDilogBinding.lytMain.setBackgroundTintList(ContextCompat.getColorStateList(context,MyUgcButton.SHEET_COLOR));
        sheetDilogBinding.tvTitle.setTextColor(ContextCompat.getColor(context,MyUgcButton.FONT_COLOR));
        sheetDilogBinding.btnclose.setImageTintList(ContextCompat.getColorStateList(context,MyUgcButton.FONT_COLOR));
        sheetDilogBinding.etDes.setTextColor(ContextCompat.getColor(context,MyUgcButton.FONT_COLOR));
        sheetDilogBinding.etDes.setHintTextColor(ContextCompat.getColor(context,MyUgcButton.HINT_COLOR));
      //  sheetDilogBinding.btnSubmit.setTextColor(ContextCompat.getColor(context,MyUgcButton.FONT_COLOR));
        sheetDilogBinding.btnSubmit.setBackgroundTintList(ContextCompat.getColorStateList(context,MyUgcButton.BUTTTON_COLOR));


        sheetDilogBinding.btnclose.setOnClickListener(v -> bottomSheetDialog.dismiss());
        sheetDilogBinding.etDes.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//ll
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().equals("")) {
                    sheetDilogBinding.btnSubmit.setBackgroundTintList(ContextCompat.getColorStateList(context, R.color.gray));
                    submitButtonEnable = false;
                } else {
                    sheetDilogBinding.btnSubmit.setBackgroundTintList(ContextCompat.getColorStateList(context, R.color.black));
                    sheetDilogBinding.btnSubmit.setTextColor(ContextCompat.getColor(context, R.color.white));
                    submitButtonEnable = true;

                }
            }

            @Override
            public void afterTextChanged(Editable s) {
//ll
            }
        });
        sheetDilogBinding.btnSubmit.setOnClickListener(v -> {
            if (submitButtonEnable) {
                Toast.makeText(context, "Report Submitted", Toast.LENGTH_SHORT).show();
                onReportedListner.onReported();
                bottomSheetDialog.dismiss();
              /*  JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty(Const.USER_TYPE, "user");
                jsonObject.addProperty(Const.Host_id,hostId);
                jsonObject.addProperty(Const.User_id,userId);
                jsonObject.addProperty(Const.Description,sheetDilogBinding.etDes.getText().toString().trim());
                Call<ReportRoot> call = RetrofitBuilder.create().sendReportOfUser(jsonObject);
                call.enqueue(new Callback<ReportRoot>() {
                    @Override
                    public void onResponse(Call<ReportRoot> call, Response<ReportRoot> response) {
                        if (response.code() == 200) {
                            if (response.body().isStatus()) {
                                onReportedListner.onReported();
                                bottomSheetDialog.dismiss();
                            } else {
                                Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                    @Override
                    public void onFailure(Call<ReportRoot> call, Throwable t) {
//ll
                    }
                });*/
            }
        });

    }

    public interface OnReportedListner {
        void onReported();
    }
}
