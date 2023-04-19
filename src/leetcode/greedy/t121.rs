pub struct Solution {

}

impl Solution {
    pub fn max_profit(prices: Vec<i32>) -> i32 {
        let len = prices.len();
        let mut res = vec![0; len];
        let mut min = prices[0];
        for i in 1..len {
            res[i] = res[i-1].max(prices[i] - min);
            if prices[i] < min {
                min = prices[i];
            }
        }
        *res.last().unwrap()
    }
}

