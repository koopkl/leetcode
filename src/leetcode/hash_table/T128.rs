use std::collections::HashSet;

pub struct Solution {}

impl Solution {
    pub fn longest_consecutive(nums: Vec<i32>) -> i32 {
        let mut map = HashSet::new();
        for num in &nums {
            map.insert(num);
        }
        let mut res = 0;

        for num in &nums {
            let mut temp = num.clone();
            let mut count = 1;
            if !map.contains(&temp) {
                continue;
            }
            while map.len() > 0 && map.contains(&((temp + 1).clone())) {
                map.remove(&((temp + 1).clone()));
                count += 1;
                temp += 1;
            }
            temp = num.clone();
            while map.len() > 0 && map.contains(&((temp - 1).clone())) {
                map.remove(&((temp - 1).clone()));
                count += 1;
                temp -= 1;
            }
            if count > res {
                res = count;
            }

        }
        res
    }
}