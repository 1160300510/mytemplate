public class IntegerBIT{
    int[] data;
    int n;
    public IntegerBIT(int n){
        this.n = n;
        data = new int[n+1];
    }
    public int lowbit(int x){
        return x & (-x);
    }
    public void update(int i, int mod){
        if(i<=0){
            return;
        }
        while(i <= n){
            data[i] += mod;
            i += lowbit(i);
        }
    }
    public int query(int i){
        int sum = 0;
        while(i > 0){
            sum += data[i];
            i -= lowbit(i);
        }
        return sum;
    }
}
