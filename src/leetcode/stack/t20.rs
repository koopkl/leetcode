pub struct Solution {

}

impl Solution {
    pub fn is_valid(s: String) -> bool {
        let mut stack = vec![];
        let chars = s.chars().collect::<Vec<char>>();
        for ch in chars {
            match ch {
                ']' => {
                    if stack.len() == 0 {
                        return false
                    }
                    if stack[stack.len() - 1] != '[' {
                        return false
                    }
                    stack.pop();
                },
                '}' => {
                    if stack.len() == 0 {
                        return false
                    }
                    if stack[stack.len() - 1] != '{' {
                        return false
                    }
                    stack.pop();

                },
                ')' => {
                    if stack.len() == 0 {
                        return false
                    }
                    if stack[stack.len() - 1] != '(' {
                        return false
                    }
                    stack.pop();
                },
                _ => {
                    stack.push(ch);
                }
            }
        }
        stack.len() == 0
    }
}