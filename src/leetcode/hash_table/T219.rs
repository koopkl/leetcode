use std::collections::HashMap;

pub struct Solution {

}
impl Solution {
    pub fn contains_nearby_duplicate(nums: Vec<i32>, k: i32) -> bool {

        let mut map:HashMap<i32, i32> = HashMap::new();
        for i in 0..nums.len() {
            if let Some(val) = map.get(&nums[i]) {
                if (*val - (i as i32)).abs() <= k {
                    return true
                }
            }
            map.insert(nums[i], i as i32);
        }
        false
    }
}