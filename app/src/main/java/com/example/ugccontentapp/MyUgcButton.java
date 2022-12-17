package com.example.ugccontentapp;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

public class MyUgcButton {


    private Context context;
    private View reportVIew;
    public static int SHEET_COLOR = R.color.black;
    public static  int FONT_COLOR = R.color.white;
    public static  int HINT_COLOR = R.color.gray;
    public static  int BUTTTON_COLOR = R.color.purple_500;
    public   boolean isFlagShow;

    public OnUGCTapListner getOnUGCTapListner() {
        return onUGCTapListner;
    }

    public void setOnUGCTapListner(OnUGCTapListner onUGCTapListner) {
        this.onUGCTapListner = onUGCTapListner;
    }

    OnUGCTapListner onUGCTapListner;


    public MyUgcButton(Context context, boolean isFlagShow, View reportVIew) {
        this.context = context;

        this.reportVIew = reportVIew;

        initMain(isFlagShow);
    }

    private void initMain(boolean isFlagShow) {
        reportVIew.setOnClickListener(view -> {
            new UGCsheetChoice(context,isFlagShow, new UGCsheetChoice.OnChoiceLisnter() {
                @Override
                public void onClickReporte() {
                    new UGCReportSheet(context,"","",() -> {
onUGCTapListner.onClickReported();
                    });
                }

                @Override
                public void onClickBlock() {
                    Toast.makeText(context, "Blocked", Toast.LENGTH_SHORT).show();
onUGCTapListner.onClickBlockd();
                }

                @Override
                public void onClickFlag() {
onUGCTapListner.onClickFlagd();
                }
            });

        });
    }
    public  interface OnUGCTapListner{
        void onClickReported();

        void onClickBlockd();

        void onClickFlagd();
    }

    /*public MyUgcButton(Context context) {

      *//*  BottomSheetReportBinding sheetDilogBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.bottom_sheet_report, null, false);

     ItemMyUgcButtonBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_my_ugc_button, null, false);
*//*




    }*/

    public static void init(int SHEET_COLOR ,int FONT_COLOR,int HINT_COLOR,int BUTTTON_COLOR) {

        MyUgcButton.  SHEET_COLOR = SHEET_COLOR;
        MyUgcButton.   FONT_COLOR = FONT_COLOR;
        MyUgcButton.   HINT_COLOR = HINT_COLOR;
        MyUgcButton.   BUTTTON_COLOR = BUTTTON_COLOR;

    }
}
