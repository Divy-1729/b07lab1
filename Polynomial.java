public class Polynomial{
    double [] coeff;



public Polynomial(){
   this.coeff = new double[1];
} 

public Polynomial(double [] coefficients){
    coeff = coefficients;
}

public Polynomial add(Polynomial to_add){
    double[] newer = to_add.coeff;
    int len = Math.max(newer.length, coeff.length);
    double[] sum = new double[len];
    if (newer.length < coeff.length){
    for (int i = 0; i < newer.length; i++){
        sum[i] = coeff[i] + newer[i];
    }
    for (int j = newer.length; j < this.coeff.length; j++) {
        sum[j] = this.coeff[j];}
    }
    else{
        for (int i = 0; i < this.coeff.length; i++) {
            sum[i] = this.coeff[i] + newer[i];
        }
        for (int j = this.coeff.length; j < newer.length; j++) {
            sum[j] = newer[j];
        }
    }
    return new Polynomial(sum);
}

public double evaluate(double x){
    double val = 0.0;
    for (int i = 0; i < coeff.length; i++){
        val = val + (coeff[i]*Math.pow(x, i));
    }
    return val;
}

public boolean hasRoot(double y){
    return this.evaluate(y) == 0;
}

}