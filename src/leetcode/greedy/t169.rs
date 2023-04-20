pub struct Solution {
    
}

impl Solution {
    pub fn majority_element(nums: Vec<i32>) -> i32 {
        // 摩尔投票法
        let mut can = 0;
        let mut count = 0;
        for num in nums {
           if count == 0 {
               can = num;
               count += 1;
           } else if num == can{
               count += 1;
           } else if num != can {
               count -= 1;
           }
        }
        can
    }
}