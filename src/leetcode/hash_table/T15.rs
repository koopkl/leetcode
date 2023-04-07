pub struct Solution {
    
}

impl Solution {
    pub fn three_sum(nums: Vec<i32>) -> Vec<Vec<i32>> {
        let mut nums_clone = nums.clone();
        nums_clone.sort();
        let mut res = vec![];
        let mut i = 0;
        // println!("{:?}", nums_clone);
        while i < nums_clone.len() {
            if i > 0 && nums_clone[i] == nums_clone[i - 1] {
                i += 1;
                continue;
            }
            let mut left: i32 = (i + 1) as i32;
            let mut right: i32 = (nums_clone.len() - 1) as i32;
            // println!("xxx{left}, {right}");
            while left < right {
                // println!("uuu{left}, {right}");
                let sum_three = nums_clone[i] + nums_clone[left as usize] + nums_clone[right as usize];
                if sum_three == 0 {
                    res.push(vec![nums_clone[i],  nums_clone[left as usize], nums_clone[right as usize]]);
                    while left < right && nums_clone[left as usize] == nums_clone[(left + 1) as usize] {
                        left += 1;
                    }
                    while left < right && nums_clone[right as usize] == nums_clone[(right - 1) as usize] {
                        right -= 1;
                    }
                    left += 1;
                    right -= 1;
                } else if sum_three > 0 {
                    right -= 1;
                } else if sum_three < 0 {
                    left += 1;
                }
            }
            i += 1;
        }
        res
    }
}