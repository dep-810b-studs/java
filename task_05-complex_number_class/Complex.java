package com.company;
 
import java.util.ArrayList;
 
public class Complex {
 
 
    public Complex()
    {
 
    }
 
    public  Complex(Complex val)
    {
        this.real = val.real;
        this.imaginary = val.imaginary;
    }
 
    public  Complex(double real , double imaginary)
    {
        this.real = real;
        this.imaginary = imaginary;
    }
 
    public  Complex sum(Complex right)
    {
        this.real+=right.real;
        this.imaginary+= right.imaginary;
 
        return this;
    }
 
    public  static  Complex sum(Complex left, Complex right)
    {
        Complex res = new Complex(left);
 
       return   res.sum(right);
    }
 
    public  Complex multiply(Complex right)
    {
        this.real = this.real*right.real - this.imaginary*right.imaginary;
        this.imaginary = this.imaginary * right.real + this.real * right.imaginary;
 
        return this;
    }
 
    public  static  Complex multiply(Complex left, Complex right)
    {
     Complex res = new Complex(left);
 
     return res.multiply(right);
    }
 
    public Complex division(Complex right)
    {
        if (right.magnitude() == 0) throw  new IllegalArgumentException("Division by zero!");
        this.real = (this.real *right.real + this.imaginary * right.imaginary)/(right.real * right.real + right.imaginary*right.imaginary);
        this.imaginary = (this.imaginary * right.real + this.real * right.imaginary)/(right.real * right.real + right.imaginary*right.imaginary);
 
        return this;
    }
 
    public  static Complex division (Complex left, Complex right)
    {
        Complex res = new Complex(left);
 
        return res.division(right);
    }
 
    private Complex pow(double degree)
    {
 
        this.real = this.real == 0 ? 0 : Math.pow(this.magnitude(),degree) * Math.cos(degree * this.phase());
        this.imaginary = this.imaginary == 0 ? 0 : Math.pow(this.magnitude(),degree) * Math.sin(degree * this.phase());
 
        return this;
    }
 
    public  static  Complex pow(Complex val, double degree)
    {
        return val.pow(degree);
    }
 
    private ArrayList<Complex>  sqrt(int n)
    {
        ArrayList<Complex> res = new ArrayList<>();
 
        for (int i = 0; i< n;++i)
        {
            double real = Math.sqrt(this.phase()) * Math.cos((this.phase() + 2 * i * Math.PI)/n);
            double imaginary = Math.sqrt(this.phase()) * Math.sin((this.phase() + 2 * i * Math.PI)/n);
 
            res.add(new Complex(real,imaginary));
        }
 
        return res;
 
    }
 
    public  static ArrayList<Complex> sqrt(Complex val, int n)
    {
        return val.sqrt(n);
    }
 
    public  double magnitude()
    {
        if (real > 0)
            return Math.sqrt(real*real+imaginary*imaginary);
        if (real < 0 && imaginary >= 0)  return Math.PI + Math.sqrt(real*real+imaginary*imaginary);
        if ( real < 0 && imaginary < 0) return  -Math.PI + Math.sqrt(real*real+imaginary*imaginary);
        if(real == 0 && imaginary >0) return Math.PI/2;
        if(real == 0 && imaginary <0) return -Math.PI/2;
        return 0;
    }
 
    public double phase()
    {
        return Math.atan2(imaginary,real);
    }
 
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Complex{");
        sb.append("real=").append(real);
        sb.append(", imaginary=").append(imaginary);
        sb.append('}');
        return sb.toString();
    }
 
    private double real = 0;
    private  double imaginary = 0;
}
