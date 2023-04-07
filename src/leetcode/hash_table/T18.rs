pub struct Solution {

}

impl Solution {
    pub fn four_sum(nums: Vec<i32>, target: i32) -> Vec<Vec<i32>> {
        let mut sorted_nums = nums.clone();
        sorted_nums.sort();
        let mut res = vec![];
        for i in 0..sorted_nums.len() - 1 {
            if i > 0 && sorted_nums[i] == sorted_nums[i - 1] {
                continue;
            }
            for j in (i + 1)..sorted_nums.len() {
                if j > i + 1 && sorted_nums[j] == sorted_nums[j - 1] {
                    continue;
                }
                let mut left = j + 1;
                let mut right = nums.len() - 1;
                let mut u_left = left as usize;
                let mut u_right = right as usize;
                while left < right {
                    u_left = left as usize;
                    u_right = right as usize;
                    let mut sum_four = (sorted_nums[i] as i64 + sorted_nums[j] as i64 + sorted_nums[u_left] as i64 + sorted_nums[u_right] as i64) ;
                    if sum_four == (target as i64) {
                        res.push(vec![sorted_nums[i], sorted_nums[j], sorted_nums[u_left], sorted_nums[u_right]]);
                        while left < right && sorted_nums[left] == sorted_nums[left + 1] {
                            left += 1;
                        }
                        while left < right && sorted_nums[right] == sorted_nums[right - 1] {
                            right -= 1;
                        }
                        left += 1;
                        right -= 1;
                    } else if sum_four < target as i64 {
                        left += 1;
                    } else {
                        right -= 1;
                    }
                }
            }
        }
        res
    }
}