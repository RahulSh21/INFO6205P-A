package edu.northeastern.rahul;

public class Main {

    public static void main(String[] args) {
        int[] num = {0,1,3,50,75};
        int lower = 0, upper = 99;

        System.out.println( smallSORTED(num, lower, upper));

    }

    public static String[] smallSORTED(int[] num, int lower, int upper){
        if(num[0] == lower && num[0] == upper){
            return null;
        }
        int size = num.length-1;
        String r = "";
        if(num[0] != lower){
            r = r + lower +" ->" + (num[0]-1) + ",";
        }
        for(int i = 0; i< size-1; i++){
            int j= i+1;
            int check = num[j] - num[i];
            if( check  > 1 ){

                r = r + (num[i]+1) + " ->" + (num[j]-1)+ ",";
            }
        }
        if(num[size] != upper){
            r = r + (num[size]-1) +" ->" +upper ;
        }
        String[] result = r.split(",");
        return result;
    }




}
