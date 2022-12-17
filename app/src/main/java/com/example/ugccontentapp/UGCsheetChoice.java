package com.example.ugccontentapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;


import com.example.ugccontentapp.databinding.BottomSheetUgcBinding;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class UGCsheetChoice {

    private final BottomSheetDialog bottomSheetDialog;
    private boolean submitButtonEnable = false;

    public UGCsheetChoice(Context context, boolean isFlagShow, OnChoiceLisnter onReportedListner) {
        bottomSheetDialog = new BottomSheetDialog(context, R.style.CustomBottomSheetDialogTheme);
        bottomSheetDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
   /*     bottomSheetDialog.setOnShowListener(dialog -> {
            BottomSheetDialog d = (BottomSheetDialog) dialog;
            FrameLayout bottomSheet = (FrameLayout) d.findViewById(R.id.design_bottom_sheet);
            BottomSheetBehavior.from(bottomSheet)
                    .setState(BottomSheetBehavior.STATE_EXPANDED);
        });*/


        BottomSheetUgcBinding sheetDilogBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.bottom_sheet_ugc, null, false);
        bottomSheetDialog.setContentView(sheetDilogBinding.getRoot());
        bottomSheetDialog.show();
sheetDilogBinding.mainLyt.setBackgroundTintList(ContextCompat.getColorStateList(context,MyUgcButton.SHEET_COLOR));
sheetDilogBinding.tvBlock.setTextColor(ContextCompat.getColor(context,MyUgcButton.FONT_COLOR));
sheetDilogBinding.tvReport.setTextColor(ContextCompat.getColor(context,MyUgcButton.FONT_COLOR));
sheetDilogBinding.tvFlag.setTextColor(ContextCompat.getColor(context,MyUgcButton.FONT_COLOR));

if (!isFlagShow){
    sheetDilogBinding.tvFlag.setVisibility(View.GONE);
}
        sheetDilogBinding.tvBlock.setOnClickListener(view -> {
            onReportedListner.onClickBlock();
            bottomSheetDialog.dismiss();
        });
        sheetDilogBinding.tvReport.setOnClickListener(view -> {
            onReportedListner.onClickReporte();
            bottomSheetDialog.dismiss();
        });

        sheetDilogBinding.tvFlag.setOnClickListener(v -> {
            onReportedListner.onClickFlag();
            bottomSheetDialog.dismiss();
        });


    }

    public interface OnChoiceLisnter {
        void onClickReporte();

        void onClickBlock();

        void onClickFlag();
    }
}
