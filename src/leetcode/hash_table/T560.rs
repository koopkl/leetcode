use std::collections::HashMap;

pub struct Solution {}

impl Solution {
    pub fn subarray_sum(nums: Vec<i32>, k: i32) -> i32 {
        let mut sum = 0;
        let mut map = HashMap::new();
        let mut count = 0;
        map.insert(0, 1);
        for i in 0..nums.len() {
            let num = nums[i];
            sum += num;
            if let Some(c) = map.get(&(sum - k)) {
                count += c;
            }
            let val = map.entry(sum).or_insert(0);
            *val += 1;
        }
        count
    }
}