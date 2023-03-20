use std::collections::HashMap;
use std::hash::Hash;

pub struct Solution {

}

impl Solution {
    pub fn find_shortest_sub_array(nums: Vec<i32>) -> i32 {
        let mut map:HashMap<i32, Vec<i32>> = HashMap::new();
        for i in 0..nums.len() {
            let j = i as i32;
            let vec = map.entry(nums[i]).or_insert(vec![0, j, j]);
            vec[0] += 1;
            vec[2] = j;
        }
        let mut max_count = 0;
        let mut min_len = nums.len() as i32;
        for value in map.values() {
            println!("{:?}", value);
            if value[0] > max_count {
                max_count = value[0];
                min_len = value[2] - value[1];
            } else if value[0] == max_count{
                if value[2] - value[1] < min_len {
                    min_len = value[2] - value[1];
                }
            }

        }
        min_len + 1
    }
}