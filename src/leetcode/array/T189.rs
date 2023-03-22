pub struct Solution {

}
use std::cmp::Ordering;

impl Solution {
    // method 1
    pub fn rotate(nums: &mut Vec<i32>, k: i32) {
        let len = nums.len();
        let k = (k as usize % len) as usize;
        let count = Self::gcd(len.clone() as i32, k.clone() as i32);
        for i in 0..count as usize {
            let mut start = i;
            let mut next = (i + k) %  len;
            let mut temp = nums[start];
            while start != next {
                let ttt = nums[next].clone();
                nums[next] = temp;
                temp = ttt;
                next = (next + k) % len;
            }
            let ttt = nums[next].clone();
            nums[next] = temp;
            temp = ttt;
            next = (next + k) % len;
        }
    }
    fn gcd(mut a: i32, mut b: i32) -> i32 {
        while b != 0 {
            let t = b;
            b = a % b;
            a = t;
        }
        a
    }
    // method 2
    pub fn rotate2(nums: &mut Vec<i32>, k: i32) {
        let dup = nums.clone();
        for i in 0..nums.len(){
            let len = nums.len();
            nums[(i + k as usize) % len] = dup[i];
        }
    }


}