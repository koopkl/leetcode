use std::collections::{HashMap, HashSet};
pub struct Solution {

}
impl Solution {
    pub fn find_error_nums(nums: Vec<i32>) -> Vec<i32> {
        let mut map = HashMap::new();
        let mut sum = 0;
        let mut dup = 0;
        for i in &nums {
            sum += i;
            if let Some(x) = map.get(&i) {
                dup = *i;
            } else {
                map.insert(i, 1);
            }
        }
        vec![dup, dup + (((1 + nums.len()) * nums.len()) as i32 / 2) - sum]
    }
}