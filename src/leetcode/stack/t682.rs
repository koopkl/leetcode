pub struct Solution {

}

impl Solution {
    pub fn cal_points(operations: Vec<String>) -> i32 {
        let mut stack: Vec<i32> = vec![];
        for op in operations {
            match op.as_str() {
                "+" => {
                    stack.push(stack[stack.len() - 1] + stack[stack.len() - 2]);
                },
                "D" => {
                    stack.push(stack[stack.len() - 1] * 2);
                },
                "C" => {
                    stack.pop();
                },
                _ => {
                    stack.push(op.parse::<i32>().unwrap());
                }
            }
        }
        stack.into_iter().sum()
    }
}