package com.syntexterror.bdjobsolution;

public class Model_for_Quiz_row {



    public  static  final  int IMAGE_TYPE= 1 ;
    public  String title, subtitle , Image ;
    private int type ;


    public  Model_for_Quiz_row (int mtype , String mtitle , String msubtitle , String Image ){

        this.title = mtitle ;
        this.Image = Image ;
        this.subtitle = msubtitle ;
        this.type = mtype ;



    }
}
