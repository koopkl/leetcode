use std::collections::{HashMap, HashSet};

pub struct Solution {

}

impl Solution {
    pub fn contains_duplicate(nums: Vec<i32>) -> bool {
        nums.iter().collect::<HashSet<_>>().len() != nums.len()
    }
}