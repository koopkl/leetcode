pub struct Solution {

}

impl Solution {
    pub fn super_pow(a: i32, mut b: Vec<i32>) -> i32 {
        if let Some(end) = b.pop() {
            return Self::my_pow(Self::super_pow(a, b), 10) * Self::my_pow(a, end as u32) % 1337
        } else {
            1
        }
    }

    pub fn my_pow(a: i32, mut b: u32) -> i32{
        let mut ans = 1;
        while b > 0 {
            ans = (ans as i64 * a as i64) % 1337;
            b -= 1;
        }
        ans as i32
    }
}