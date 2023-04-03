


pub struct Solution {


}

impl Solution {
    pub fn contains_nearby_almost_duplicate(nums: Vec<i32>, index_diff: i32, value_diff: i32) -> bool {
        // 暴力
        for i in 0..nums.len() {
            let k = i as i32;
            let mut j = if k - index_diff < 0 { 0 } else { k - index_diff };
            while j < nums.len() as i32 && j <= k + index_diff {
                let m = j as usize;
                if k != j && (nums[i] - nums[m]).abs() <= value_diff {
                    return true
                }
                j += 1;
            }
        }
        false
    }
}