pub struct Solution {
    
}

impl Solution {
    pub fn summary_ranges(nums: Vec<i32>) -> Vec<String> {
        let mut res: Vec<Vec<i32>> = vec![];

        if nums.len() == 0 {
            return vec![]
        }
        let mut temp = vec![nums[0]];
        if nums.len() == 1 {
            res.push(temp);
        } else {
            for i in 1..nums.len() {
                if nums[i] != (nums[i - 1] + 1) {
                    if temp[0] != nums[i - 1] {
                        temp.push(nums[i - 1]);
                    }
                    res.push(temp.clone());
                    temp = vec![nums[i]];
                }
            }
            if temp[0] != *nums.last().unwrap() {
                temp.push(*nums.last().unwrap());
            }
            res.push(temp.clone());
        }
        // println!("{:?}", res);
        // vec![]
        res.into_iter().map(|x| {
            x.into_iter().map(|x| x.to_string()).collect::<Vec<String>>().join("->")
        }).collect::<Vec<String>>()
    }
}