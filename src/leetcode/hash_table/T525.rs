use std::collections::HashMap;

pub struct Solution {

}

impl Solution {
    pub fn find_max_length(nums: Vec<i32>) -> i32 {
        let mut map: HashMap<i32, i32> = HashMap::new();
        let mut sum = 0;
        map.insert(0, -1);
        let mut max = 0;
        for i in 0..nums.len() {
            let num = nums[i];
            if num == 1 {
                sum += 1;
            } else {
                sum -= 1;
            }
            if let Some(c) = map.get(&sum) {
                max = max.max(i as i32 - c);
            } else {
                map.insert(sum, i as i32);
            }
        }
        max as i32
    }
}