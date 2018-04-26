%module mathish

   %{
    extern double calcPI(long num_steps=10000,int num_threads=4);
   %}

extern double calcPI(long num_steps=10000,int num_threads=4);
