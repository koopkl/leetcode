pub struct Solution {

}

impl Solution {
    pub fn max_profit(prices: Vec<i32>) -> i32 {
        let mut res = 0;
        let len = prices.len();
        for i in 1..len {
           res += 0.max(prices[i] - prices[i - 1]);
        }
        res
    }
}