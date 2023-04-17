pub struct Solution {
    
}

impl Solution {
    pub fn eval_rpn(tokens: Vec<String>) -> i32 {
        let mut stack: Vec<i32> = vec![];
        tokens.into_iter().for_each(|op| {
            match op.as_str() {
                "+" => {
                    let b = stack.pop().unwrap();
                    let a = stack.pop().unwrap();
                    stack.push(a + b);
                },
                "-" => {
                    let b = stack.pop().unwrap();
                    let a = stack.pop().unwrap();
                    stack.push(a - b);
                },
                "*" => {
                    let b = stack.pop().unwrap();
                    let a = stack.pop().unwrap();
                    stack.push(a * b);
                },
                "/" => {
                    let b = stack.pop().unwrap();
                    let a = stack.pop().unwrap();
                    stack.push(a / b);
                },
                _ => {
                    stack.push(op.parse::<i32>().unwrap());
                }
            }
        });
        stack.pop().unwrap()
    }
}