pub struct Solution {

}
impl Solution {
    pub fn check_perfect_number(num: i32) -> bool {
        if num == 1 {
            return false
        }
        let mut sum = 1;
        for i in 2..=(num as f64).sqrt() as i32 {
            if num % i == 0 {
                sum += i;
                sum += num / i;
            }
        }
        sum == num
    }
}