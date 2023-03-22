pub struct NumArray {
    values: Vec<i32>
}


/**
 * `&self` means the method takes an immutable reference.
 * If you need a mutable reference, change it to `&mut self` instead.
 */
impl NumArray {

    pub fn new(nums: Vec<i32>) -> Self {
        let mut res = vec![nums[0]];
        for i in 1..nums.len() {
            res.push(res.last().unwrap() + nums[i]);
        }
        println!("{:?}", res);
        return NumArray{
            values: res.clone()
        }
    }

    pub fn sum_range(&self, left: i32, right: i32) -> i32 {
        let mut min = left - 1;
        if min < 0 {
            return self.values[right as usize]
        }
        self.values[right as usize]- self.values[min as usize]
    }
}