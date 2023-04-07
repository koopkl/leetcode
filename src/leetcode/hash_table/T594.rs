use std::collections::HashMap;

pub struct Solution {}

impl Solution {
    pub fn find_lhs(nums: Vec<i32>) -> i32 {
        let mut map = HashMap::new();
        let mut res = i32::MIN;
        for val in &nums {
            let val = map.entry(val).or_insert(0);
            *val += 1;
        }
        for val in &nums {
            if map.contains_key(&(val + 1)) {
                res = res.max(map.get(&val).unwrap() + map.get(&(val + 1)).unwrap());
            }
        }
        res
    }
}