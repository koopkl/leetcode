pub struct Solution {

}

impl Solution {
    pub fn maximum_swap(num: i32) -> i32 {
        // 暴力
        let mut nums = num.to_string().chars().map(|x| x.to_digit(10).unwrap() as i32).collect::<Vec<i32>>();
        // max[i] when k >= i, max[i] >= nums[k]
        let mut max:Vec<i32> = vec![-1; nums.len()];
        let mut temp_num_max = -1;
        let mut temp_num_max_index: i32 = -1;
        println!("{:?}, {}", nums,nums.len() - 1);
        for i in (0..=(nums.len() - 1)).rev() {
            if nums[i] > temp_num_max {
                max[i] = i as i32;
                temp_num_max = nums[i];
                temp_num_max_index = i as i32;
            } else {
                max[i] = temp_num_max_index as i32;
            }
        }
        println!("{:?}", max);
        let mut i = 0;
        while i < nums.len() - 1 {
            if i != (max[i] as usize) && nums[i] != nums[max[i + 1] as usize]{
                let temp = nums[i];
                nums[i]= nums[max[i + 1] as usize];
                nums[max[i + 1] as usize] = temp;
                break
            }
            i += 1;
        }
        nums.into_iter().map(|x| x.to_string()).collect::<String>().parse::<i32>().unwrap()
    }
}